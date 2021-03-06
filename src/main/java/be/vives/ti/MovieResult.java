package be.vives.ti;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieResult {

    private String totalResults;
    @JsonProperty("Response")
    private String response;
    @JsonProperty("Search")
    private List<MovieDetails> search;

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }


    public List<MovieDetails> getSearch() {
        return search;
    }

    public void setSearch(List<MovieDetails> search) {
        this.search = search;
    }
}
