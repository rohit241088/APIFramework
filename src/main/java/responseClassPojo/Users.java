package responseClassPojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;




@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "per_page",
        "total",
        "total_pages",
        "data",
        "support"
})

public class Users {

    @JsonProperty("page")
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("data")
    private List<data> data = null;
    @JsonProperty("support")
    private Support support;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    public Users withPage(Integer page) {
        this.page = page;
        return this;
    }

    @JsonProperty("per_page")
    public Integer getPerPage() {
        return perPage;
    }

    @JsonProperty("per_page")
    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Users withPerPage(Integer perPage) {
        this.perPage = perPage;
        return this;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    public Users withTotal(Integer total) {
        this.total = total;
        return this;
    }

    @JsonProperty("total_pages")
    public Integer getTotalPages() {
        return totalPages;
    }

    @JsonProperty("total_pages")
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Users withTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    @JsonProperty("data")
    public List<data> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<data> data) {
        this.data = data;
    }

    public Users withData(List<data> data) {
        this.data = data;
        return this;
    }

    @JsonProperty("support")
    public Support getSupport() {
        return support;
    }

    @JsonProperty("support")
    public void setSupport(Support support) {
        this.support = support;
    }

    public Users withSupport(Support support) {
        this.support = support;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Users withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "id",
            "email",
            "first_name",
            "last_name",
            "avatar"
    })

    public class data {

        @JsonProperty("id")
        private Integer id;
        @JsonProperty("email")
        private String email;
        @JsonProperty("first_name")
        private String firstName;
        @JsonProperty("last_name")
        private String lastName;
        @JsonProperty("avatar")
        private String avatar;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        public data withId(Integer id) {
            this.id = id;
            return this;
        }

        @JsonProperty("email")
        public String getEmail() {
            return email;
        }

        @JsonProperty("email")
        public void setEmail(String email) {
            this.email = email;
        }

        public data withEmail(String email) {
            this.email = email;
            return this;
        }

        @JsonProperty("first_name")
        public String getFirstName() {
            return firstName;
        }

        @JsonProperty("first_name")
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public data withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        @JsonProperty("last_name")
        public String getLastName() {
            return lastName;
        }

        @JsonProperty("last_name")
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public data withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @JsonProperty("avatar")
        public String getAvatar() {
            return avatar;
        }

        @JsonProperty("avatar")
        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public data withAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        public data withAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
            return this;
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "url",
            "text"
    })

    public class Support {

        @JsonProperty("url")
        private String url;
        @JsonProperty("text")
        private String text;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("url")
        public String getUrl() {
            return url;
        }

        @JsonProperty("url")
        public void setUrl(String url) {
            this.url = url;
        }

        public Support withUrl(String url) {
            this.url = url;
            return this;
        }

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("text")
        public void setText(String text) {
            this.text = text;
        }

        public Support withText(String text) {
            this.text = text;
            return this;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        public Support withAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
            return this;
        }

    }

}

