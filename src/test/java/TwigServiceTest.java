import org.junit.Before;
import org.junit.Test;
import tasks.employer.beans.Twig;
import tasks.employer.service.TwigService;

import static junit.framework.Assert.assertEquals;


public class TwigServiceTest {

    private TwigService service;

        @Before
        public void init() {
            service = new TwigService();
        }

        @Test
    public void getMaxLevelTest(){

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

//            tree.getTwigs().get(1).getTwigs().get(1).getTwigs().get(0).getTwigs().add(new Twig());

            assertEquals(4, service.getMaxLevel(tree));
//            assertEquals(5, service.getMaxLevel(tree,0,0));

    }
}
