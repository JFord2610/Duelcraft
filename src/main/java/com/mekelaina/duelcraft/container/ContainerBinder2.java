package com.mekelaina.duelcraft.container;

import com.mekelaina.duelcraft.items.ItemCardBinder;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerBinder2 extends CommonContainer
{
    private InventoryPlayer playerInv;
    IItemHandler binderInv;
    private ItemCardBinder binderItem;
    private int refX, refY;
    private int numRows;
    private final int SLOT_WIDTH = 18;

    public ContainerBinder2(InventoryPlayer playerInv, IItemHandler binderInv, int numSlots, Item ItemIn)
    {
        super(numSlots);
        this.playerInv = playerInv;
        this.binderInv = binderInv;
        this.binderItem = (ItemCardBinder) ItemIn;
        this.numRows = 9;

        for (int x = 0; x < numRows; x++)
        {
            for (int y = 0; y < 6; y++)
            {
                int index = (x + (y * 6)) + 35;
                int xPos = 100 + (x * SLOT_WIDTH);
                int yPos = 100 + (y * SLOT_WIDTH);

                this.addSlotToContainer(new SlotItemHandler(binderInv, index, xPos, yPos));
            }
        }

        for (int y = 0; y < 3; ++y)
        {
            for (int x = 0; x < 9; ++x)
            {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, (x * 18) + 8, 86 + y * 18));
                // x + y * 9 + 9
                // 0 + 0 * 9 + 9 = 9
                // 1 + 0 * 9 + 9 = 10
                // 2 + 0 * 9 + 9 = 11
                // 3 + 0 * 9 + 9 = 12
                // 4 + 0 * 9 + 9 = 13
                // 5 + 0 * 9 + 9 = 14
                // 6 + 0 * 9 + 9 = 15
                // 7 + 0 * 9 + 9 = 16
                // 8 + 0 * 9 + 9 = 17
                // 0 + 1 * 9 + 9 = 18
                // 1 + 1 * 9 + 9 = 19
                // 2 + 1 * 9 + 9 = 20
                // 3 + 1 * 9 + 9 = 21
                // 4 + 1 * 9 + 9 = 22
                // 5 + 1 * 9 + 9 = 23
                // 6 + 1 * 9 + 9 = 24
                // 7 + 1 * 9 + 9 = 25
                // 8 + 1 * 9 + 9 = 26
                // ...
            }
        }

        // Hot bar
        for (int x = 0; x < 9; ++x)
        {
            this.addSlotToContainer(new Slot(playerInv, x, (x * 18) + 8, 144));
        }


    }

    public void setRefValues(int x, int y)
    {
        refX = x;
        refY = y;
    }
}
