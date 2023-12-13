package pwo.lab08.engine;

import java.math.BigDecimal;

public interface SequenceGenerator {

    void reset();

    BigDecimal nextTerm();

    BigDecimal getTerm(int i);
}
