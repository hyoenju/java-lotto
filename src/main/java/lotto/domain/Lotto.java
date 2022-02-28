package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int COUNT = 6;
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;

    private static final List<LottoNumber> NUMBER_SEQUENCES = generateNumberSequence();
    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        this(generateRandomNumbers());
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static List<LottoNumber> generateRandomNumbers() {
        List<LottoNumber> numbers = new ArrayList<>(NUMBER_SEQUENCES);
        Collections.shuffle(numbers);
        return numbers.subList(0, COUNT)
            .stream()
            .sorted(Comparator.comparing(LottoNumber::getNumber))
            .collect(Collectors.toList());
    }

    private static List<LottoNumber> generateNumberSequence() {
        return IntStream.rangeClosed(START_RANGE, END_RANGE)
            .boxed().map(LottoNumber::from)
            .collect(Collectors.toList());
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 길이가 %d 이어야 합니다.", COUNT));
        }
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList())
            .contains(number.getNumber());
    }

    public int matchCount(Lotto otherLotto) {
        return (int) lottoNumbers.stream().filter(otherLotto::contains).count();
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList()).toString();
    }
}