package ADA;

import java.util.*;

class Item {
    int weight;
    int value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

class Node {
    int level, profit, bound;
    int weight;
    List<Integer> selectedItems;

    Node(int level, int profit, int weight, List<Integer> selectedItems) {
        this.level = level;
        this.profit = profit;
        this.weight = weight;
        this.selectedItems = new ArrayList<>(selectedItems);
    }
}

public class KnapsackBranchAndBound {
    static int knapsack(int capacity, Item[] items) {
        Arrays.sort(items, Comparator.comparingDouble((Item item) -> (double) item.value / item.weight).reversed());

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> -node.bound));

        Node root = new Node(-1, 0, 0, new ArrayList<>());
        root.bound = calculateBound(root, items, capacity);

        int maxProfit = 0;
        List<Integer> selectedItems = null;

        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.level + 1 < items.length) {
                List<Integer> selected = new ArrayList<>(current.selectedItems);
                selected.add(current.level + 1);

                Node leftChild = new Node(current.level + 1,
                        current.profit + items[current.level + 1].value,
                        current.weight + items[current.level + 1].weight,
                        selected);

                leftChild.bound = calculateBound(leftChild, items, capacity);

                if (leftChild.weight <= capacity && leftChild.profit > maxProfit) {
                    maxProfit = leftChild.profit;
                    selectedItems = leftChild.selectedItems;
                }

                if (leftChild.bound > maxProfit) {
                    queue.offer(leftChild);
                }

                Node rightChild = new Node(current.level + 1,
                        current.profit,
                        current.weight,
                        new ArrayList<>(current.selectedItems));

                rightChild.bound = calculateBound(rightChild, items, capacity);

                if (rightChild.bound > maxProfit) {
                    queue.offer(rightChild);
                }
            }
        }

        if (selectedItems != null) {
            System.out.println("Selected items:");
            for (int index : selectedItems) {
                System.out.println("Item " + (index + 1) + ": Weight = " + items[index].weight + ", Value = " + items[index].value);
            }
        }

        return maxProfit;
    }

    static int calculateBound(Node node, Item[] items, int capacity) {
        int totalWeight = node.weight;
        int totalProfit = node.profit;
        int level = node.level + 1;

        while (level < items.length && totalWeight + items[level].weight <= capacity) {
            totalWeight += items[level].weight;
            totalProfit += items[level].value;
            level++;
        }

        if (level < items.length) {
            totalProfit += (capacity - totalWeight) * ((double) items[level].value / items[level].weight);
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(2, 6),
                new Item(2, 10),
                new Item(3, 12),
                new Item(4, 13),
                new Item(5, 16)
        };
        int capacity = 10;

        int maxProfit = knapsack(capacity, items);
        System.out.println("Maximum profit for knapsack with capacity " + capacity + " = " + maxProfit);
    }
}