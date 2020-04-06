package flysong.darkages.block.tileEntity;

import flysong.darkages.interfaces.IFuel;

public class TileEntityEnergyAlternator extends TileEntityEnergyMachine implements IFuel {
    private int fuel = 0;

    @Override
    public int getFuel() {
        return fuel;
    }

    @Override
    public void setFuel(int fuel) {
        this.fuel=fuel;
    }

    @Override
    public void addFuel(int fuel) {
        this.fuel+=fuel;
    }

    @Override
    public void subFuel(int fuel) {
        this.fuel-=fuel;
    }
}
