package flysong.darkages.capability;

public interface IPlayerEnergy {
    public int getPlayerEnergy();
    public void addPlayerEnergy(int num);
    public void resetPlayerEnergy();
    public void subPlayerEnergy(int num);
    public void setPlayerEnergy(int num);
}
