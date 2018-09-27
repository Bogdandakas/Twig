package tasks.employer.service;

import tasks.employer.beans.Twig;

import java.util.Random;

public class TwigServiceImpl implements TwigService {

    private static final int NUMBER = 1000; // Use the Random to select between 0 and NUMBER
    private int maxTwigs = new Random().nextInt(NUMBER); // the maximum of twigs in the tree

    public int getMaxLevel(Twig tree) {

        return null != tree ? getMaxLevel(tree, 0, 0) : 0;
    }

    public Twig createTreeRandom() {

        Twig tree = new Twig();

        if (maxTwigs == 1) {
            return tree;
        } else {
            maxTwigs--;
        }

        int countTwigs = new Random().nextInt(NUMBER);
        for (int i = 0; i < countTwigs; i++) {
            tree.getTwigs().add(createTreeRandom());
        }

        return tree;
    }

    private int getMaxLevel(Twig tree, int levelCounter, int level) {

        levelCounter++;

        for (Twig twig : tree.getTwigs()) {

            level = getMaxLevel(twig, levelCounter, level);
        }
        return Math.max(level, levelCounter);
    }
}
