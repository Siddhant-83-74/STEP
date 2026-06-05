public class InventoryReorderSystem {

    public static boolean needsReorder(int stock, int safetyStock, boolean seasonal, boolean discount, int dailySales) {
        return (stock <= safetyStock) ||
               (seasonal && stock <= dailySales * 3) ||
               (discount && stock <= 20);
    }

    public static boolean isUrgent(int stock, int dailySales, int leadDays, boolean seasonal, boolean discount) {
        return (stock <= dailySales * 2) &&
               (leadDays > 3 || seasonal) &&
               !(discount && stock > 10);
    }

    public static int getUrgencyCode(int stock, boolean seasonal, boolean discount, int leadDays) {
        int code = 0;

        if (stock < 10) {
            code = code | 1;
        }
        if (seasonal) {
            code = code | 2;
        }
        if (discount) {
            code = code | 4;
        }
        if (leadDays > 5) {
            code = code | 8;
        }

        return code;
    }

    public static int getReorderQty(int stock, int dailySales, int leadDays, boolean seasonal) {
        int qty1 = (int) (stock * 0.5);
        int qty2 = dailySales * leadDays;
        int baseQty = Math.max(qty1, qty2);

        if (seasonal) {
            baseQty *= 2;
        }

        return baseQty;
    }

    public static String getAction(int stock, int safetyStock, int dailySales, int leadDays, boolean seasonal, boolean discount) {
        boolean reorder = needsReorder(stock, safetyStock, seasonal, discount, dailySales);
        boolean urgent = isUrgent(stock, dailySales, leadDays, seasonal, discount);
        int qty = getReorderQty(stock, dailySales, leadDays, seasonal);
        int code = getUrgencyCode(stock, seasonal, discount, leadDays);

        if (urgent) {
            return "URGENT! Qty: " + qty + " | Urgency: 0b" + Integer.toBinaryString(code);
        } else if (reorder) {
            return "Reorder | Qty: " + qty + " | Urgency: 0b" + Integer.toBinaryString(code);
        } else if (seasonal ^ discount) {
            return "Monitor closely";
        } else {
            return "No action required";
        }
    }

    public static void main(String[] args) {
        System.out.println("P101 -> " + getAction(45, 20, 12, 4, false, false));
        System.out.println("P102 -> " + getAction(18, 20, 15, 2, true, false));
        System.out.println("P103 -> " + getAction(5, 10, 8, 5, false, true));
        System.out.println("P104 -> " + getAction(120, 30, 20, 7, false, false));
        System.out.println("P105 -> " + getAction(25, 20, 30, 3, true, true));
    }
}