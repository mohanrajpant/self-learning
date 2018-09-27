package basicfunctional.design;

public class Asset {
    public enum AssetType { BOND, STOCK };
    private final AssetType assetType;
    private final int value;

    public Asset(AssetType assetType, int value) {
        this.assetType = assetType;
        this.value = value;
    }

    public AssetType getType() {
        return assetType;
    }

    public int getValue() {
        return value;
    }
}
