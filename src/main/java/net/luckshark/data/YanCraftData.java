package net.luckshark.data;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record YanCraftData(BlockPos pos) implements BlockPosPayload {
    public static final PacketCodec<RegistryByteBuf, YanCraftData> CODEC =
            PacketCodec.tuple(BlockPos.PACKET_CODEC, YanCraftData::pos, YanCraftData::new);
}
