package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DisplayName("Calculator Testsuite for adding two variables")
class CalculatorTest {

    final Calculator CLASS_UNDER_TEST = Calculator.create();

    @Nested
    class NominalTests {
        @Test
        void when_addingTwoValues_expect_theCorrectResult() {
            assertThat(CLASS_UNDER_TEST.add(5, 6)).isEqualTo(11);
        }
    }

    @Nested
    class BoundaryTests {
        @Test
        void when_addingHugePositiveNumbers_expect_propperOverflowHandling() {
            assertThat(CLASS_UNDER_TEST.add(Integer.MAX_VALUE, 1)).isEqualTo(Integer.MIN_VALUE);
        }

        @Test
        void when_addingSmallNegativeNumbers_expect_propperUnderflowHandling() {
            assertThat(CLASS_UNDER_TEST.add(Integer.MIN_VALUE, -1)).isEqualTo(Integer.MAX_VALUE);
        }
    }
}


