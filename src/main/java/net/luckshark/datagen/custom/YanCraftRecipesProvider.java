package net.luckshark.datagen.custom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.luckshark.Bark;
import net.luckshark.item.ModItems;
import net.minecraft.item.Item;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class YanCraftRecipesProvider {

    static int count = 0;
    static final String resourcesRoot = "F:/IDEA/Bark/bark-Fabric-1.21.1/src/main/resources/";
    public static void generate(){
        for (int i = 0; i < ModItems.BARK_LIST.size(); i++) {
            genRecipe(ModItems.BARK_LIST.get(i), ModItems.BARK_ESSENCE_LIST.get(i));
        }

        System.out.println("YanCraftRecipesProvider: A total of " + count + " files are generated");
    }

    private static void genRecipe(Item input, Item output) {
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
        if (Boolean.FALSE.equals(writeFile(file, input, output))) {
            System.out.println("writeFile error");
        }
    }
    private static Boolean writeFile(File file, Item input, Item output) {

        String type = Bark.MOD_ID + ':' + "yan_craft";
        String ingredientItem = input.toString();
        String outputId = output.toString();
        String filePath = file.getPath();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", type);

        JsonArray ingredientsArray = new JsonArray();
        JsonObject ingredientObject = new JsonObject();
        ingredientObject.addProperty("item", ingredientItem);
        ingredientsArray.add(ingredientObject);
        jsonObject.add("ingredients", ingredientsArray);

        JsonObject outputObject = new JsonObject();
        outputObject.addProperty("id", outputId);
        jsonObject.add("output", outputObject);

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(jsonObject, writer);
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
