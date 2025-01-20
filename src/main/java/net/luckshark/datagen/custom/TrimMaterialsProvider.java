package net.luckshark.datagen.custom;

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
            .put(ModItems.OAK_BARK_ESSENCE, "#836741")
            .put(ModItems.SPRUCE_BARK_ESSENCE, "#231006")
            .put(ModItems.BIRCH_BARK_ESSENCE, "#bebeae")
            .put(ModItems.JUNGLE_BARK_ESSENCE, "#635820")
            .put(ModItems.ACACIA_BARK_ESSENCE, "#696259")
            .put(ModItems.DARK_OAK_BARK_ESSENCE, "#1c150b")
            .put(ModItems.MANGROVE_BARK_ESSENCE, "#584526")
            .put(ModItems.CHERRY_BARK_ESSENCE, "#301d29")
            .put(ModItems.CRIMSON_BARK_ESSENCE, "#7b0000")
            .put(ModItems.WARPED_BARK_ESSENCE, "#16615b")
            .put(ModItems.BAMBOO_BARK_ESSENCE, "#828f38")
            .build();
    static final Map<Item, Float> indexMap = (new ImmutableMap.Builder<Item, Float>())
            .put(ModItems.OAK_BARK_ESSENCE, 0.11f)
            .put(ModItems.SPRUCE_BARK_ESSENCE, 0.12f)
            .put(ModItems.BIRCH_BARK_ESSENCE, 0.13f)
            .put(ModItems.JUNGLE_BARK_ESSENCE, 0.14f)
            .put(ModItems.ACACIA_BARK_ESSENCE, 0.15f)
            .put(ModItems.DARK_OAK_BARK_ESSENCE, 0.16f)
            .put(ModItems.MANGROVE_BARK_ESSENCE, 0.17f)
            .put(ModItems.CHERRY_BARK_ESSENCE, 0.18f)
            .put(ModItems.CRIMSON_BARK_ESSENCE, 0.19f)
            .put(ModItems.WARPED_BARK_ESSENCE, 0.21f)
            .put(ModItems.BAMBOO_BARK_ESSENCE, 0.22f)
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

    //设置为true时，将尝试删除此类目前所有将会生成的文件。一般在此类已经生成文件后，清理这些文件使用。
    private static final boolean deleteModel = false;

    public static void generate(List<Item> list) {
        trimMaterials(list);
        armorTrims(list);
        blocks(list);
        models(ModItems.BARK_ARMOR_LIST, list);
        models(vanillaArmorList, list);

        System.out.println("TrimMaterialsProvider: A total of " + count + " files are generated");
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
            if (createFile(file1)) {
                if (!writeFile(content1, file1)) {
                    System.out.println("writeFile error");
                    return;
                }
            }else {
                System.out.println("craeteFile error");
            }

            for (Item materialItem : materialsList) {
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
                if (!createFile(file2)) {
                    System.out.println("craeteFile error");
                    continue;
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
        String content = """
                {
                  "sources": [
                    {
                      "type": "paletted_permutations",
                      "textures": [
                        "trims/items/leggings_trim",
                        "trims/items/chestplate_trim",
                        "trims/items/helmet_trim",
                        "trims/items/boots_trim"
                      ],
                      "palette_key": "trims/color_palettes/trim_palette",
                      "permutations": {
                      }
                    }
                  ]
                }""";
        if (!createPath(resourcesRoot + "assets/minecraft/atlases/")) {
            System.out.println("createPath error");
            return;
        }
        if (!createFile(file)) {
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

            for (Item item : list) {
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
        String content = """
                {
                  "sources": [
                    {
                      "type": "paletted_permutations",
                      "textures": [
                        "trims/models/armor/coast",
                        "trims/models/armor/coast_leggings",
                        "trims/models/armor/sentry",
                        "trims/models/armor/sentry_leggings",
                        "trims/models/armor/dune",
                        "trims/models/armor/dune_leggings",
                        "trims/models/armor/wild",
                        "trims/models/armor/wild_leggings",
                        "trims/models/armor/ward",
                        "trims/models/armor/ward_leggings",
                        "trims/models/armor/eye",
                        "trims/models/armor/eye_leggings",
                        "trims/models/armor/vex",
                        "trims/models/armor/vex_leggings",
                        "trims/models/armor/tide",
                        "trims/models/armor/tide_leggings",
                        "trims/models/armor/snout",
                        "trims/models/armor/snout_leggings",
                        "trims/models/armor/rib",
                        "trims/models/armor/rib_leggings",
                        "trims/models/armor/spire",
                        "trims/models/armor/spire_leggings",
                        "trims/models/armor/wayfinder",
                        "trims/models/armor/wayfinder_leggings",
                        "trims/models/armor/shaper",
                        "trims/models/armor/shaper_leggings",
                        "trims/models/armor/silence",
                        "trims/models/armor/silence_leggings",
                        "trims/models/armor/raiser",
                        "trims/models/armor/raiser_leggings",
                        "trims/models/armor/host",
                        "trims/models/armor/host_leggings",
                        "trims/models/armor/flow",
                        "trims/models/armor/flow_leggings",
                        "trims/models/armor/bolt",
                        "trims/models/armor/bolt_leggings"
                      ],
                      "palette_key": "trims/color_palettes/trim_palette",
                      "permutations": {
                      }
                    }
                  ]
                }""";
        if (!createPath(resourcesRoot + "assets/minecraft/atlases/")) {
            System.out.println("createPath error");
            return;
        }
        if (!createFile(file)) {
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

            for (Item item : list) {
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
        for (Item item : list) {
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
            if (!createFile(file)) {
                System.out.println("craeteFile error");
                continue;
            }
            writeFile(content, file);
        }

    }

    private static Boolean writeFile(String content, File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(content);
            return true;
        } catch (IOException e) {
            System.out.println("writeFile error" + e.getMessage());
        }
        return false;
    }

    private static Boolean createFile(File file) {
        if (file.exists()) {
            if (file.delete()) {
                if (deleteModel) {
                    return false;
                }
            }else {
                return false;
            }
        }else if (deleteModel) {
            return false;
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
