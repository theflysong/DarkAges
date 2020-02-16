package flysong.darkages.init;

import flysong.darkages.Modlog;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static flysong.darkages.init.ItemLoader.*;

public class MeltingLoader {
    public MeltingLoader() {
        GameRegistry.addSmelting(UnfiredCrystal,new ItemStack(Crystal,1),2.0F);
        Modlog.logger.info("Melting is Load.");
    }
}
