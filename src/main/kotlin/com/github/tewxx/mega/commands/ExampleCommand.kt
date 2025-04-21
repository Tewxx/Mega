package com.github.tewxx.mega.commands

import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.util.BlockPos
import net.minecraft.util.ChatComponentText

class ExampleCommand : CommandBase() {
    override fun getCommandName(): String = "ToggleHUD"
    override fun getCommandUsage(sender: ICommandSender?): String = "/" + this.commandName
    override fun canCommandSenderUseCommand(sender: ICommandSender?): Boolean = true
    override fun getRequiredPermissionLevel(): Int = 0
    override fun processCommand(sender: ICommandSender?, args: Array<out String>?) {
        sender?.addChatMessage(ChatComponentText("Hey your command is running!"))

        if (args!!.isNotEmpty() && args[0].equals("option1", ignoreCase = true)) {
            sender!!.addChatMessage(ChatComponentText("Running option1!"))
        } else if (args.isNotEmpty() && args[0].equals("option2", ignoreCase = true)) {
            sender!!.addChatMessage(ChatComponentText("Running option2!"))
        } else if (args.isNotEmpty() && args[0].equals("option3", ignoreCase = true)) {
            sender!!.addChatMessage(ChatComponentText("Running option3!"))
        }
    }
    override fun addTabCompletionOptions(sender: ICommandSender?, args: Array<String?>, pos: BlockPos?): List<String> {
        val options = arrayOf("option1", "option2", "option3")
        return getListOfStringsMatchingLastWord(args, *options)
    }
}