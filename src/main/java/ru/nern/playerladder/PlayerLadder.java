package ru.nern.playerladder;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerLadder implements ModInitializer
{
	public static final Logger LOGGER = LoggerFactory.getLogger("playerladder");

	@Override
	public void onInitialize()
	{

		ServerPlayConnectionEvents.DISCONNECT.register((handler, server) ->
		{
			if(handler.player.hasVehicle() && handler.player.getVehicle() instanceof PlayerEntity)
				handler.player.stopRiding();
		});
	}
}
