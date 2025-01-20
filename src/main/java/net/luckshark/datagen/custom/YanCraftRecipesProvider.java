package net.luckshark.datagen.custom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.luckshark.Bark;
import net.luckshark.block.ModBlocks;
import net.luckshark.item.ModItems;
import net.minecraft.item.Item;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class YanCraftRecipesProvider {

    static int count = 0;
    static final String resourcesRoot = "F:/IDEA/Bark/bark-Fabric-1.21.1/src/main/resources/";
    public static void generate(){
        for (int i = 0; i < ModItems.BARK_LIST.size(); i++) {
            genRecipe(ModItems.BARK_LIST.get(i), ModBlocks.QUILMOR.asItem(), ModItems.BARK_ESSENCE_LIST.get(i));
        }

        System.out.println("YanCraftRecipesProvider: A total of " + count + " files are generated");
    }

    private static void genRecipe(Item input1, Item input2, Item output) {
        if (!createPath(resourcesRoot + "data/" + Bark.MOD_ID + "/recipe/")) {
            System.out.println("createPath error");
            return;
        }
        String fileName = getId(output);
        File file = new File(resourcesRoot + "data/" + Bark.MOD_ID + "/recipe/" + fileName + ".json");
        if (!createFile(file)) {
            System.out.println("craeteFile error");
            return;
        }
        if (Boolean.FALSE.equals(writeFile(file, input1, input2, output))) {
            System.out.println("writeFile error");
        }
    }
    private static Boolean writeFile(File file, Item input_1, Item input_2, Item out_put) {

        String type = Bark.MOD_ID + ':' + "yan_craft";
        String input1Item = input_1.toString();
        String input2Item = input_2.toString();
        String outputId = out_put.toString();
        String filePath = file.getPath();

        Map<String, Object> barkCraft = new HashMap<>();
        barkCraft.put("type", type);

        Map<String, String> input1 = new HashMap<>();
        input1.put("item", input1Item);

        Map<String, String> input2 = new HashMap<>();
        input2.put("item", input2Item);

        Map<String, String> output = new HashMap<>();
        output.put("id", outputId);

        barkCraft.put("input1", input1);
        barkCraft.put("input2", input2);
        barkCraft.put("output", output);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(barkCraft, writer);
        } catch (IOException ignored) {
            return false;
        }
        return null;
    }

    private static Boolean createFile(File file) {
        if (file.exists()) {
            if (!file.delete()) {
                return false;
            }
        }
        try {
            if (file.createNewFile()) {
                count ++;
                return true;
            }
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
        return false;
    }

    private static Boolean createPath(String path){
        File dir = new File(path);
        if (!dir.exists()) {
            return dir.mkdirs();
        }
        return true;
    }

    private static String getId(Item item) {
        return item.toString().split(":")[1];
    }
}
