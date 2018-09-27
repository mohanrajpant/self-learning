package basicfunctional.design;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static basicfunctional.design.Asset.AssetType.BOND;
import static basicfunctional.design.Asset.AssetType.STOCK;

public class AssetUtil {

    public static void main(String[] args) {
        final List<Asset> assets = Arrays.asList(
            new Asset(BOND, 1000),
            new Asset(BOND, 2000),
            new Asset(STOCK, 3000),
            new Asset(STOCK, 4000)
        );

        System.out.println("Total of all assets: " + totalAssetValues(assets));
        System.out.println("Total of bonds: " + totalBondValues(assets));
        System.out.println("Total of stocks: " + totalStockValues(assets));

        System.out.println("Total of all assets: " + totalAssetValues(assets, asset -> true));
        System.out.println("Total of bonds: " + totalAssetValues(assets, asset -> asset.getType() == BOND));
        System.out.println("Total of stocks: " + totalAssetValues(assets, asset -> asset.getType() == STOCK));

    }

    public static int totalAssetValues(List<Asset> assets) {
        return assets.stream()
            .mapToInt(Asset::getValue)
            .sum();
    }

    public static int totalBondValues(List<Asset> assets) {
        return assets.stream()
            .filter(asset -> asset.getType() == BOND)
            .mapToInt(Asset::getValue)
            .sum();
    }

    private static int totalStockValues(List<Asset> assets) {
        return assets.stream()
            .filter(asset -> asset.getType() == STOCK)
            .mapToInt(Asset::getValue)
            .sum();
    }

    // refactored

    public static int totalAssetValues(List<Asset> assets, Predicate<Asset> assetSelector) {
        return assets.stream()
            .filter(assetSelector)
            .mapToInt(Asset::getValue)
            .sum();
    }

}
