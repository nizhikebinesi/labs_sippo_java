package com.examples.skripov.sippo.lesson2.problem;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.condition.sign.ConditionSign;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;
import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.Extremum;
import com.examples.skripov.sippo.lesson2.problem.processor.ProblemProcessor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ProblemTest {

    private Problem problem;

    @Before
    public void setUp() {
        ArrayList<Fraction> coefficients = new ArrayList<>(Arrays.asList(new Fraction(1), new Fraction(2)));
        ObjectiveFunction function = new ObjectiveFunction(Extremum.MAX, coefficients);

        Condition condition1 = new Condition(
                ConditionSign.EQUAL,
                new ArrayList<>(Arrays.asList(
                        new Fraction(2),
                        new Fraction(3))),
                new Fraction(1));
        Condition condition2 = new Condition(
                ConditionSign.LESS_OR_EQUAL,
                new ArrayList<>(Arrays.asList(
                        new Fraction(4),
                        new Fraction(5))),
                new Fraction(2));
        Condition condition3 = new Condition(
                ConditionSign.MORE_OR_EQUAL,
                new ArrayList<>(Arrays.asList(
                        new Fraction(0),
                        new Fraction(1))),
                new Fraction(3));

        problem = ProblemProcessor.makeCanonicalProblem(
                new Problem(function, new ArrayList<>(Arrays.asList(condition1, condition2, condition3)))
        );
    }

    @Test
    public void testAddVariable() {
        problem.addArtificialVariables();
        System.out.println(problem);
    }
}
