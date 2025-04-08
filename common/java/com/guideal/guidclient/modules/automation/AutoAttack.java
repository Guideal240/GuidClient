package com.guideal.guidclient.modules.automation;

import com.guideal.guidclient.common.Events;
import com.guideal.guidclient.configs.AutoAttackConfig;
import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.modules.Module;
import com.guideal.guidclient.wrappers.AttackRange;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class AutoAttack implements Module {

    public static final AutoAttack instance = new AutoAttack();

    private final Minecraft mc = Minecraft.getInstance();

    private AutoAttack() {
        Events.ClientTickEnd.add(this::onClientTickEnd);
    }

    private void onClientTickEnd() {
        if (mc.player == null) {
            return;
        }

        AutoAttackConfig config = ConfigStore.instance.getConfig().autoAttackConfig;
        if (!config.enabled) {
            return;
        }

        if (!mc.options.keyAttack.isDown()) {
            return;
        }

        if (mc.hitResult == null) {
            return;
        }

        if (mc.hitResult.getType() != HitResult.Type.ENTITY) {
            return;
        }

        if (mc.player.getAttackStrengthScale((float) -config.extraTicks) != 1) {
            return;
        }

        Entity entity = ((EntityHitResult) mc.hitResult).getEntity();
        if (AttackRange.canHit(entity)) {
            mc.gameMode.attack(mc.player, entity);
            mc.player.swing(InteractionHand.MAIN_HAND);
        }
    }
}