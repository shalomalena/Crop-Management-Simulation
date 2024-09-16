public class CropDetailsBST {
    private CropNode root;

    public CropDetailsBST() {
        this.root = null;
    }

    public void insert(String type, int growthTime, int salePrice, int waterNeeded, int fertilizerNeeded, double yieldMultiplier) {
        root = insertRec(root, type, growthTime, salePrice, waterNeeded, fertilizerNeeded, yieldMultiplier);
    }

    private CropNode insertRec(CropNode root, String type, int growthTime, int salePrice, int waterNeeded, int fertilizerNeeded, double yieldMultiplier) {
        if (root == null) {
            return new CropNode(type, growthTime, salePrice, waterNeeded, fertilizerNeeded, yieldMultiplier);
        }
        if (type.compareTo(root.type) < 0) {
            root.left = insertRec(root.left, type, growthTime, salePrice, waterNeeded, fertilizerNeeded, yieldMultiplier);
        } else if (type.compareTo(root.type) > 0) {
            root.right = insertRec(root.right, type, growthTime, salePrice, waterNeeded, fertilizerNeeded, yieldMultiplier);
        }
        return root;
    }

    public CropNode search(String type) {
        return searchRec(root, type);
    }

    private CropNode searchRec(CropNode root, String type) {
        if (root == null || root.type.equals(type)) {
            return root;
        }
        if (type.compareTo(root.type) < 0) {
            return searchRec(root.left, type);
        } else {
            return searchRec(root.right, type);
        }
    }
}
