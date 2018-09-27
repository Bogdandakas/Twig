package tasks.employer.service;

import tasks.employer.beans.Twig;


public interface TwigService {

    int getMaxLevel(Twig tree);

    Twig createTreeRandom();

}
