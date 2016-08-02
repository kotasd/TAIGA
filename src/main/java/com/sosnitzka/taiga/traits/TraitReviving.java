package com.sosnitzka.taiga.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;


public class TraitReviving extends AbstractTrait {


    public final float chance = 0.15f;

    public TraitReviving() {
        super("reviving", TextFormatting.DARK_PURPLE);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onEntityKill(LivingDeathEvent event) {
        BlockPos pos = event.getEntity().getPosition();
        World w = event.getEntity().getEntityWorld();
        if (!w.isRemote && event.getSource().getEntity() != null) {
            if (event.getSource().getEntity() instanceof EntityPlayer && event.getEntity() instanceof EntityLiving) {
                if (random.nextFloat() <= chance && TinkerUtil.hasTrait(TagUtil.getTagSafe(((EntityPlayer) event.getSource().getEntity()).getHeldItemMainhand()), identifier)) {
                    String mobClass = event.getEntity().getClass().getName();
                    Entity ent = null;
                    try {
                        ent = (Entity) Class.forName(mobClass).getConstructor(World.class).newInstance(w);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    if (ent != null) {
                        ent.setPosition(pos.getX(), pos.getY(), pos.getZ());
                        w.spawnEntityInWorld(ent);
                        event.getSource().getEntity().playSound(SoundEvents.AMBIENT_CAVE, 1.0F, 1.0F);
                    }
                }
            }
        }
    }
}
