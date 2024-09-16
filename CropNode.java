public class CropNode {
    String type;
    int growthTime;
    int salePrice;
    int waterNeeded;
    int fertilizerNeeded;
    double yieldMultiplier;
    CropNode left, right;

    public CropNode(String type, int growthTime, int salePrice, int waterNeeded, int fertilizerNeeded, double yieldMultiplier) {
        this.type = type;
        this.growthTime = growthTime;
        this.salePrice = salePrice;
        this.waterNeeded = waterNeeded;
        this.fertilizerNeeded = fertilizerNeeded;
        this.yieldMultiplier = yieldMultiplier;
        this.left = null;
        this.right = null;
    }
}
