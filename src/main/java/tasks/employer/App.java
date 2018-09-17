package tasks.employer;

import sun.rmi.log.LogHandler;
import tasks.employer.beans.Twig;
import tasks.employer.service.TwigService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static Logger logger = Logger.getLogger(LogHandler.class.getName());

    public static void main(String[] args) {

        runApp();
    }

    private static void runApp() {

        TwigService service = new TwigService();

        int result = service.getMaxLevel(createTree());
        logger.log(Level.INFO, "The deepest level of tree(created manually) is: " + result);

        int result2 = service.getMaxLevel(service.createTreeRandom());
        logger.log(Level.INFO, "The deepest level of tree(created with random) is: " + result2);
    }

    private static Twig createTree() {

        Twig tree = new Twig();

        tree.getTwigs().add(new Twig());
        tree.getTwigs().add(new Twig());

        tree.getTwigs().get(0).getTwigs().add(new Twig());

        tree.getTwigs().get(1).getTwigs().add(new Twig());
        tree.getTwigs().get(1).getTwigs().add(new Twig());
        tree.getTwigs().get(1).getTwigs().add(new Twig());

        tree.getTwigs().get(1).getTwigs().get(0).getTwigs().add(new Twig());
        tree.getTwigs().get(1).getTwigs().get(1).getTwigs().add(new Twig());
        tree.getTwigs().get(1).getTwigs().get(1).getTwigs().add(new Twig());

        tree.getTwigs().get(1).getTwigs().get(1).getTwigs().get(0).getTwigs().add(new Twig());

        return tree;
    }



}