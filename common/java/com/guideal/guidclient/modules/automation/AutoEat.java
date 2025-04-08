package com.guideal.guidclient.modules.automation;

import com.guideal.guidclient.common.Events;
import com.guideal.guidclient.configs.AutoEatConfig;
import com.guideal.guidclient.configs.ConfigStore;
import com.guideal.guidclient.helpers.MixinMultiPlayerGameModeHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;

public class AutoEat {

    public static final AutoEat instance = new AutoEat();

    private final Minecraft mc = Minecraft.getInstance();
    private State state;

    private AutoEat() {
        Events.ClientTickStart.add(this::onClickTickStart);
        state = State.NONE;
    }

    private void onClickTickStart() {
        if (mc.player == null || mc.level == null) {
            return;
        }

        AutoEatConfig config = ConfigStore.instance.getConfig().autoEatConfig;
        if (config.enabled && (!config.isHungerLimitEnabled || mc.player.getFoodData().getFoodLevel() <= config.hungerLimit)) {
            ItemStack itemStack = mc.player.getInventory().offhand.get(0);
            if (itemStack.isEdible() && mc.player.getFoodData().needsFood()) {
                startEating();
            } else {
                stopEating();
            }
        } else {
            stopEating();
        }
    }

    private void startEating() {
        if (state == State.NONE || mc.player.getUseItem().isEmpty()) {
            InteractionResult result = mc.gameMode.useItem(mc.player, InteractionHand.OFF_HAND);
            if (result.consumesAction()) {
                mc.gameRenderer.itemInHandRenderer.itemUsed(InteractionHand.OFF_HAND);
                MixinMultiPlayerGameModeHelper.disableReleaseUsingItem = true;
                state = State.EATING;
            }
        }
    }

    private void stopEating() {
        if (state == State.EATING) {
            mc.gameMode.releaseUsingItem(mc.player);
            MixinMultiPlayerGameModeHelper.disableReleaseUsingItem = false;
            state = State.NONE;
        }
    }

    private enum State {
        NONE,
        EATING
    }
}