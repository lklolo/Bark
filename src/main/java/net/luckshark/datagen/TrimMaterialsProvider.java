package net.luckshark.datagen;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonArray;
import net.luckshark.Bark;
import net.luckshark.item.ModItems;
import net.minecraft.item.Item;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.item.Items;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrimMaterialsProvider {

    static int count = 0;
    static final String resourcesRoot = "F:/IDEA/Bark/bark-Fabric-1.21.1/src/main/resources/";
    static final Map<Item, String> colorMap = (new ImmutableMap.Builder<Item, String>())
            .put(ModItems.OAK_BARK, "#ffffff")
            .put(ModItems.SPRUCE_BARK, "#7f7f7f")
            .put(ModItems.BIRCH_BARK, "#ffff00")
            .put(ModItems.JUNGLE_BARK, "#00ff00")
            .put(ModItems.ACACIA_BARK, "#ff0000")
            .put(ModItems.DARK_OAK_BARK, "#0000ff")
            .put(ModItems.MANGROVE_BARK, "#00ffff")
            .put(ModItems.CHERRY_BARK, "#ff00ff")
            .put(ModItems.CRIMSON_BARK, "#ff8000")
            .put(ModItems.WARPED_BARK, "#ff0000")
            .put(ModItems.BAMBOO_BARK, "#00ff00")
            .build();
    static final Map<Item, Float> indexMap = (new ImmutableMap.Builder<Item, Float>())
            .put(ModItems.OAK_BARK, 0.11f)
            .put(ModItems.SPRUCE_BARK, 0.12f)
            .put(ModItems.BIRCH_BARK, 0.13f)
            .put(ModItems.JUNGLE_BARK, 0.14f)
            .put(ModItems.ACACIA_BARK, 0.15f)
            .put(ModItems.DARK_OAK_BARK, 0.16f)
            .put(ModItems.MANGROVE_BARK, 0.17f)
            .put(ModItems.CHERRY_BARK, 0.18f)
            .put(ModItems.CRIMSON_BARK, 0.19f)
            .put(ModItems.WARPED_BARK, 0.21f)
            .put(ModItems.BAMBOO_BARK, 0.22f)
            .build();
    static final List<Item> vanillaArmorList = new ArrayList<>() {
        {
            add(Items.LEATHER_HELMET);
            add(Items.LEATHER_CHESTPLATE);
            add(Items.LEATHER_LEGGINGS);
            add(Items.LEATHER_BOOTS);
            add(Items.GOLDEN_HELMET);
            add(Items.GOLDEN_CHESTPLATE);
            add(Items.GOLDEN_LEGGINGS);
            add(Items.GOLDEN_BOOTS);
            add(Items.IRON_HELMET);
            add(Items.IRON_CHESTPLATE);
            add(Items.IRON_LEGGINGS);
            add(Items.IRON_BOOTS);
            add(Items.DIAMOND_HELMET);
            add(Items.DIAMOND_CHESTPLATE);
            add(Items.DIAMOND_LEGGINGS);
            add(Items.DIAMOND_BOOTS);
            add(Items.NETHERITE_HELMET);
            add(Items.NETHERITE_CHESTPLATE);
            add(Items.NETHERITE_LEGGINGS);
            add(Items.NETHERITE_BOOTS);
            add(Items.CHAINMAIL_HELMET);
            add(Items.CHAINMAIL_CHESTPLATE);
            add(Items.CHAINMAIL_LEGGINGS);
            add(Items.CHAINMAIL_BOOTS);
        }
    };


    public static void main(List<Item> list) {
        trimMaterials(list);
        armorTrims(list);
        blocks(list);
        models(ModItems.BARK_ARMOR_LIST, list);
        models(vanillaArmorList, list);

        System.out.println("A total of " + count + " files are generated");
    }

    private static void models(List<Item> armorList, List<Item> materialsList) {
        if (!createPath(resourcesRoot + "assets/minecraft/models/item/")) {
            System.out.println("createPath error");
            return;
        }
        if (!createPath(resourcesRoot + "assets/" + Bark.MOD_ID + "/models/item/")) {
            System.out.println("createPath error");
            return;
        }
        for (Item item : armorList) {
            String id = getId(item);
            File file1 = new File(resourcesRoot + "assets/minecraft/models/item/" + id + ".json");
            String a = getNameSpace(item) + ':' + "item/" + getId(item);
            System.out.println(a);
            String content1 = "{\n" +
                    "  \"parent\": \"minecraft:item/generated\",\n" +
                    "  \"overrides\": [\n" +
                    "    {\n" +
                    "      \"model\": \"" + a + "_quartz_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.1\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"" + a + "_netherite_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.3\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"" + a + "_redstone_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.4\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"" + a + "_copper_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.5\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"" + a + "_gold_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.6\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"" + a + "_emerald_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.7\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"" + a + "_diamond_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.8\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"" + a + "_lapis_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 0.9\n" +
                    "      }\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"model\": \"" + a + "_amethyst_trim\",\n" +
                    "      \"predicate\": {\n" +
                    "        \"trim_type\": 1.0\n" +
                    "      }\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"textures\": {\n" +
                    "    \"layer0\": \"" + a + "\"\n" +
                    "  }\n" +
                    "}";
            if (!craeteFile(file1)) {
                System.out.println("craeteFile error");
                return;
            }
            if (!writeFile(content1, file1)) {
                System.out.println("writeFile error");
                return;
            }
            for (int i1 = 0; i1 < materialsList.size(); i1++) {
                Item materialItem = materialsList.get(i1);
                String materialId = ModItems.idMap.get(materialItem);
                String b = getNameSpace(materialItem) + ':' + "item/" + getId(item);
                try {
                    String filePath = file1.getPath();
                    String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));

                    Gson gson = new Gson();
                    JsonObject jsonObject = JsonParser.parseString(jsonContent).getAsJsonObject();

                    JsonArray overridesArray = jsonObject.getAsJsonArray("overrides");

                    JsonObject newOverride = new JsonObject();
                    newOverride.addProperty("model", b + "_" + materialId + "_trim");

                    JsonObject predicate = new JsonObject();
                    predicate.addProperty("trim_type", indexMap.get(materialItem));
                    newOverride.add("predicate", predicate);

                    overridesArray.add(newOverride);

                    try (FileWriter writer = new FileWriter(filePath)) {
                        gson.toJson(jsonObject, writer);
                    }

                } catch (IOException e) {
                    System.out.println("文件读取或写入时发生错误: " + e.getMessage());
                }

                File file2 = new File(resourcesRoot + "assets/" + Bark.MOD_ID + "/models/item/" + id + "_" + materialId + "_trim" + ".json");
                String content2 = "{\n" +
                        "  \"parent\": \"minecraft:item/generated\",\n" +
                        "  \"textures\": {\n" +
                        "    \"layer0\": \"" + a + "\",\n" +
                        "    \"layer1\": \"" + getNameSpace(item) + ":trims/items/" + getType(item) + "_trim_" + materialId + "\"\n" +
                        "  }\n" +
                        "}";
                if (!craeteFile(file2)) {
                    System.out.println("craeteFile error");
                    return;
                }
                if (!writeFile(content2, file2)) {
                    System.out.println("writeFile error");
                    return;
                }
            }
        }
    }

    private static void blocks(List<Item> list) {
        File file = new File(resourcesRoot + "assets/minecraft/atlases/blocks.json");
        String content = "{\n" +
                "  \"sources\": [\n" +
                "    {\n" +
                "      \"type\": \"paletted_permutations\",\n" +
                "      \"textures\": [\n" +
                "        \"trims/items/leggings_trim\",\n" +
                "        \"trims/items/chestplate_trim\",\n" +
                "        \"trims/items/helmet_trim\",\n" +
                "        \"trims/items/boots_trim\"\n" +
                "      ],\n" +
                "      \"palette_key\": \"trims/color_palettes/trim_palette\",\n" +
                "      \"permutations\": {\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        if (!createPath(resourcesRoot + "assets/minecraft/atlases/")) {
            System.out.println("createPath error");
            return;
        }
        if (!craeteFile(file)) {
            System.out.println("craeteFile error");
            return;
        }
        if (!writeFile(content, file)) {
            System.out.println("writeFile error");
            return;
        }

        try {
            String filePath = file.getPath();
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));

            Gson gson = new Gson();
            JsonObject jsonObject = JsonParser.parseString(jsonContent).getAsJsonObject();

            JsonObject sourcesObject = jsonObject
                    .getAsJsonArray("sources")
                    .get(0)
                    .getAsJsonObject();
            JsonObject permutationsObject = sourcesObject.getAsJsonObject("permutations");

            for (int i = 0; i < list.size(); i++) {
                Item item = list.get(i);
                String id = ModItems.idMap.get(item);
                permutationsObject.addProperty(id, Bark.MOD_ID + ":trims/color_palettes/" + id);
            }

            try (FileWriter fileWriter = new FileWriter(filePath)) {
                gson.toJson(jsonObject, fileWriter);
            }

        } catch (IOException e) {
            System.out.println("文件读取或写入时发生错误: " + e.getMessage());
        }
    }

    private static void armorTrims(List<Item> list) {
        File file = new File(resourcesRoot + "assets/minecraft/atlases/armor_trims.json");
        String content = "{\n" +
                "  \"sources\": [\n" +
                "    {\n" +
                "      \"type\": \"paletted_permutations\",\n" +
                "      \"textures\": [\n" +
                "        \"trims/models/armor/coast\",\n" +
                "        \"trims/models/armor/coast_leggings\",\n" +
                "        \"trims/models/armor/sentry\",\n" +
                "        \"trims/models/armor/sentry_leggings\",\n" +
                "        \"trims/models/armor/dune\",\n" +
                "        \"trims/models/armor/dune_leggings\",\n" +
                "        \"trims/models/armor/wild\",\n" +
                "        \"trims/models/armor/wild_leggings\",\n" +
                "        \"trims/models/armor/ward\",\n" +
                "        \"trims/models/armor/ward_leggings\",\n" +
                "        \"trims/models/armor/eye\",\n" +
                "        \"trims/models/armor/eye_leggings\",\n" +
                "        \"trims/models/armor/vex\",\n" +
                "        \"trims/models/armor/vex_leggings\",\n" +
                "        \"trims/models/armor/tide\",\n" +
                "        \"trims/models/armor/tide_leggings\",\n" +
                "        \"trims/models/armor/snout\",\n" +
                "        \"trims/models/armor/snout_leggings\",\n" +
                "        \"trims/models/armor/rib\",\n" +
                "        \"trims/models/armor/rib_leggings\",\n" +
                "        \"trims/models/armor/spire\",\n" +
                "        \"trims/models/armor/spire_leggings\",\n" +
                "        \"trims/models/armor/wayfinder\",\n" +
                "        \"trims/models/armor/wayfinder_leggings\",\n" +
                "        \"trims/models/armor/shaper\",\n" +
                "        \"trims/models/armor/shaper_leggings\",\n" +
                "        \"trims/models/armor/silence\",\n" +
                "        \"trims/models/armor/silence_leggings\",\n" +
                "        \"trims/models/armor/raiser\",\n" +
                "        \"trims/models/armor/raiser_leggings\",\n" +
                "        \"trims/models/armor/host\",\n" +
                "        \"trims/models/armor/host_leggings\",\n" +
                "        \"trims/models/armor/flow\",\n" +
                "        \"trims/models/armor/flow_leggings\",\n" +
                "        \"trims/models/armor/bolt\",\n" +
                "        \"trims/models/armor/bolt_leggings\"\n" +
                "      ],\n" +
                "      \"palette_key\": \"trims/color_palettes/trim_palette\",\n" +
                "      \"permutations\": {\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        if (!createPath(resourcesRoot + "assets/minecraft/atlases/")) {
            System.out.println("createPath error");
            return;
        }
        if (!craeteFile(file)) {
            System.out.println("craeteFile error");
            return;
        }
        if (!writeFile(content, file)) {
            System.out.println("writeFile error");
            return;
        }

        try {
            String filePath = file.getPath();
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));

            Gson gson = new Gson();
            JsonObject jsonObject = JsonParser.parseString(jsonContent).getAsJsonObject();

            JsonObject sourcesObject = jsonObject
                    .getAsJsonArray("sources")
                    .get(0)
                    .getAsJsonObject();
            JsonObject permutationsObject = sourcesObject.getAsJsonObject("permutations");

            for (int i = 0; i < list.size(); i++) {
                Item item = list.get(i);
                String id = ModItems.idMap.get(item);
                permutationsObject.addProperty(id, Bark.MOD_ID + ":trims/color_palettes/" + id);
            }

            try (FileWriter fileWriter = new FileWriter(filePath)) {
                gson.toJson(jsonObject, fileWriter);
            }

        } catch (IOException e) {
            System.out.println("文件读取或写入时发生错误: " + e.getMessage());
        }
    }

    private static void trimMaterials(List<Item> list) {
        if (!createPath(resourcesRoot + "data/" + Bark.MOD_ID + "/trim_material/")) {
            System.out.println("createPath error");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Item item = list.get(i);
            String id = ModItems.idMap.get(item);
            File file = new File(resourcesRoot + "data/" + Bark.MOD_ID + "/trim_material/" + id + ".json");
            String content = "{\n" +
                    "  \"asset_name\": \"" + id + "\",\n" +
                    "  \"description\": {\n" +
                    "    \"color\": \"" + colorMap.get(item) + "\",\n" +
                    "    \"translate\": \"trim_material." + Bark.MOD_ID + "." + id + "\"\n" +
                    "  },\n" +
                    "  \"ingredient\": \"" + item.toString() + "\",\n" +
                    "  \"item_model_index\": " + indexMap.get(item) + "\n" +
                    "}";
            if (!craeteFile(file)) {
                System.out.println("craeteFile error");
                return;
            }
            writeFile(content, file);
        }

    }

    private static Boolean writeFile(String content, File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(content);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("writeFile error" + e.getMessage());
        }
        return false;
    }

    private static Boolean craeteFile(File file) {
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
            if (dir.mkdirs()) {
                return true;
            }else {
                return false;
            }
        }
        return true;
    }

    private static String getId(Item item) {
        return item.toString().split(":")[1];
    }

    private static String getNameSpace(Item item) {
        return item.toString().split(":")[0];
    }

    private static String getType(Item item) {
        int lastIndex = item.toString().lastIndexOf('_');
        if (lastIndex != -1) {
            return item.toString().substring(lastIndex + 1);
        }
        return item.toString();
    }
}