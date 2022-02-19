package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void jobAscByNameTest() {
        Comparator<Job> nameAsc = new JobAscenByName();
        int rsl = nameAsc.compare(
                new Job("Work", 0),
                new Job("Chill", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void jobDscByNameTest() {
        Comparator<Job> dscName = new JobDescByName();
        int rsl = dscName.compare(
                new Job("Work", 0),
                new Job("Chill", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void jobAscPriorityTest() {
        Comparator<Job> ascPriority = new JobAscenByPriority();
        int rsl = ascPriority.compare(
                new Job("Work", 0),
                new Job("Chill", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void jobDscPriorityTest() {
        Comparator<Job> dscPriority = new JobDescByPriority();
        int rsl = dscPriority.compare(
                new Job("Work", 0),
                new Job("Chill", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
        public void jobComparatorByAscNameAndAscPriority() {
            Comparator<Job> ascNamePriority = new JobAscenByName().thenComparing(new JobAscenByPriority());
            int rsl = ascNamePriority.compare(
                    new Job("Work", 1),
                    new Job("Work", 2)
            );
            assertThat(rsl, lessThan(0));
    }

    @Test
        public void jobComparatorByDscNameAndDscPriority() {
            Comparator<Job> ascNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
            int rsl = ascNamePriority.compare(
                    new Job("Work", 1),
                    new Job("Chill", 1)
            );
            assertThat(rsl, lessThan(0));
    }
}