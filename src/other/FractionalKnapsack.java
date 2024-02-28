package other;

import java.util.Arrays;

public class FractionalKnapsack {

    static class Item implements Comparable<Item> {
        int weight;
        int profit;
        Double costPerUnitWeight;

        public Item(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
            this.costPerUnitWeight = (double) profit / weight;
        }

        @Override
        public int compareTo(Item other) {
            return other.costPerUnitWeight.compareTo(this.costPerUnitWeight);
        }
    }

    public static double getMaxProfit(int[] weights, int[] profits, int capacity) {
        Item[] items = new Item[weights.length];

        for (int i = 0; i < weights.length; i++) {
            items[i] = new Item(weights[i], profits[i]);
        }

        Arrays.sort(items);

        double totalProfit = 0.0;
        for (Item item : items) {
            int curWeight = item.weight;
            int curProfit = item.profit;

            if (capacity - curWeight >= 0) {
                // this item can be completely picked
                capacity -= curWeight;
                totalProfit += curProfit;
            } else {
                // the item can't be picked whole
                double fraction = ((double) capacity / curWeight);
                totalProfit += (curProfit * fraction);
                break; // the knapsack is full
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] profits = {60, 100, 120};
        int capacity = 50;

        double maxProfit = getMaxProfit(weights, profits, capacity);
        System.out.println("Maximum profit we can obtain = " + maxProfit);
    }
}