package com.github.tewxx.mega.config

import net.minecraftforge.common.config.Configuration
import java.io.File

object ConfigHandler {

    private lateinit var config: Configuration

    private var exampleBooleanSetting: Boolean = true
    private var exampleStringSetting: String = "Hello!"
    private var exampleDoubleSetting: Double = 10.0

    // Reads the config file and loads the values into the fields
    fun loadConfig(file: File) {
        config = Configuration(file)
        config.load()
        exampleBooleanSetting = config.get("ExampleCategoryName", "exampleBooleanSetting", true, "This is an example boolean setting").boolean
        exampleStringSetting = config.get("ExampleCategoryName", "exampleStringSetting", "Hello!", "This is an example String setting").string
        exampleDoubleSetting = config.get("ExampleCategoryName", "exampleDoubleSetting", 10.0, "This is an example double setting").double
    }

    // Call this when you want to save changed values to the config file
    fun saveConfig() {
        config.get("ExampleCategoryName", "exampleBooleanSetting", true, "This is an example boolean setting").set(exampleBooleanSetting)
        config.get("ExampleCategoryName", "exampleStringSetting", "Hello!", "This is an example String setting").set(exampleStringSetting)
        config.get("ExampleCategoryName", "exampleDoubleSetting", 10.0, "This is an example double setting").set(exampleDoubleSetting)
        if (config.hasChanged()) {
            config.save()
        }
    }
}
