package tasks.employer.service;

import tasks.employer.beans.Twig;

public class TwigService {

    public int getMaxLevel(Twig tree){
        return getMaxLevel(tree,0,0);
    }

    private int getMaxLevel(Twig tree, int levelCounter, int level) {

        levelCounter++;

        for (Twig twig : tree.getTwigs()) {

            level = getMaxLevel(twig, levelCounter, level);
        }
        return level < levelCounter ? levelCounter : level;
    }

}
