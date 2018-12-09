/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.List;

/**
 *
 * @author User
 */
public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        matcher = new All();
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(this.matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int amount, String category) {
        this.matcher = new And(this.matcher, new HasAtLeast(amount, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int amount, String category) {
        this.matcher = new And(this.matcher, new HasFewerThan(amount, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }

    public Matcher build() {
        Matcher returnedValue = this.matcher;
        this.matcher = new All();
        return returnedValue;
    }
}
