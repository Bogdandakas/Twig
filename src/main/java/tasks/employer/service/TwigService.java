package tasks.employer.service;

import tasks.employer.beans.Twig;

 import java.util.Random;

public class TwigService {

    private static final int NUMBER = 3;

    public int getMaxLevel(Twig tree) {

        return null != tree ? getMaxLevel(tree, 0, 0) : 0;
    }

    public Twig createTreeRandom() {

        Twig tree = new Twig();

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
