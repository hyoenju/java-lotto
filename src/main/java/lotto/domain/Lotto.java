package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int COUNT = 6;

    private static List<Integer> numberSequence;
    private final List<Integer> lottoNumbers;

    public Lotto() {
        this(generateRandomNumbers());
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        numberSequence = generateNumberSequence();
    }


    private List<Integer> generateNumberSequence() {
        return IntStream.rangeClosed(START_RANGE, END_RANGE)
            .boxed()
            .collect(Collectors.toList());
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>(numberSequence);
        Collections.shuffle(numbers);
        return numbers.subList(0, COUNT)
            .stream()
            .sorted()
            .collect(Collectors.toList());
        }

    public int compareLottoAndWinnerNumbers(LottoMachine lottoMachine) {
        return Long.valueOf(lottoNumbers.stream()
            .filter(lottoMachine::isContain).count()).intValue();
    }

    public int compareLottoAndBonusNumbers(final LottoMachine lottoMachine) {
        return Long.valueOf(lottoNumbers.stream()
            .filter(lottoMachine::isEqualBonusNumber).count()).intValue();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
