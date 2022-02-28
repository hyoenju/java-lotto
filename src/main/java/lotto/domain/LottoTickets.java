package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(int ticketCount) {
        this.lottoTickets = makeLottoTickets(ticketCount);
    }


    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    private List<Lotto> makeLottoTickets(final int ticketCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(new Lotto());
        }
        return lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
            "lottoTickets=" + lottoTickets +
            '}';
    }

}
