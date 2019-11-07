package com.mekelaina.duelcraft.gui;

import com.mekelaina.duelcraft.container.ContainerBinder;
import com.mekelaina.duelcraft.container.ContainerBinder2;
import com.mekelaina.duelcraft.container.ContainerDeckbox;
import com.mekelaina.duelcraft.util.Reference;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.ItemStackHandler;
import org.lwjgl.input.Keyboard;
import sun.nio.cs.ext.GB18030;

import java.io.IOException;

public class GuiBinder2 extends GuiContainer
{
    private InventoryPlayer playerInv;
    private final ItemStackHandler deckboxInv;
    //private static final ResourceLocation BG_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/deckbox.png");
    private static final ResourceLocation BG_1 = new ResourceLocation(Reference.MOD_ID, "textures/gui/basicbinder.png");
    private static final int BINDER_SEARCH = 0;
    private int refX, refY;
    private GuiTextField searchBinder;
    private ContainerBinder2 container;

    private Item deckbox;
    private int x1, x2, y1, y2, xTotal;

    public GuiBinder2(InventoryPlayer playerInv, ItemStackHandler deckboxInv, Item binder)
    {
        super(new ContainerBinder2(playerInv, deckboxInv, deckboxInv.getSlots(), binder));
        x1 = 242;
        y1 = 225;
        x2 = 44;
        y2 = 225;
        xTotal = 286;
		/*this.xSize = 256;
		this.ySize = 214;*/
        this.playerInv = playerInv;
        this.deckboxInv = deckboxInv;
        this.deckbox = binder;
        this.container = (ContainerBinder2) this.inventorySlots;

    }

    @Override
    public void initGui()
    {
        refX = (width ) / 2;
        refY = (height ) / 4;


        searchBinder = new GuiTextField(BINDER_SEARCH, mc.fontRenderer, refX + 156, refY + 5, 70, mc.fontRenderer.FONT_HEIGHT);
        //searchBinder.setEnableBackgroundDrawing(false);


        searchBinder.setEnabled(true);
        searchBinder.setFocused(true);
        searchBinder.setCanLoseFocus(true);

        Keyboard.enableRepeatEvents(true);

        this.container.setRefValues(refX, refY);

        super.initGui();
    }

    @Override
    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        searchBinder.mouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void updateScreen()
    {
        searchBinder.updateCursorCounter();
        super.updateScreen();
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        if(!searchBinder.textboxKeyTyped(typedChar, keyCode))
        {
            super.keyTyped(typedChar, keyCode);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        GlStateManager.color(1, 1, 1, 1);

        searchBinder.drawTextBox();

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1, 1, 1, 1);
        mc.getTextureManager().bindTexture(BG_1);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        /*mc.getTextureManager().bindTexture(BG_2);
        xSize = x2;
        ySize = y2;
        x += x1;
*/
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        ySize = y1;
        xSize = x1;
       /* String name = I18n.format(deckbox.getDisplayName());
        fontRenderer.drawString(name, xTotal / 4 - fontRenderer.getStringWidth(name) / 4, (int) (height - 1.5 * ySize) / 5 - 15, 0x404040);
        fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), (int) (width - 1.5 * xTotal) / 7 - 55, ySize - 130, 0x404040);*/
    }
}

