package com.eofitg.eofitgtweaks;

import com.eofitg.eofitgtweaks.event.KeyBindListener;
import com.eofitg.eofitgtweaks.service.AntiAntiAFK;
import com.eofitg.eofitgtweaks.service.AutoJump;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;

@Mod(modid = EofitgTweaks.MODID, name = EofitgTweaks.MODNAME, version = EofitgTweaks.VERSION)
public class EofitgTweaks {

    public static final String MODID = "eofitgtweaks";
    public static final String MODNAME = "eofitg Tweaks";
    public static final String VERSION = "0.1.1";

    private final AutoJump autoJump = new AutoJump();
    private final AntiAntiAFK antiAntiAFK = new AntiAntiAFK();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(new KeyBindListener());

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @EventHandler
    public void drop(FMLServerStoppedEvent event) {

        autoJump.killThread();
        antiAntiAFK.killThread();

    }

}
