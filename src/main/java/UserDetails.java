import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;


@Entity
public class UserDetails {


    @Id
    @GeneratedValue
    private String userId;
    
    @Version
    private long version;
    
    @Column
    private String password;

    @Column
    private String name;
    
    @OneToMany(mappedBy="userDetails",targetEntity=Article.class, fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();
    
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    
    @Temporal(TemporalType.DATE)
    private Date statusDate;
    
    public List<Article> getArticles() {
        return articles;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @Override
    public String toString() {
        return "UserDetails [userId=" + userId + ", password=" + password + ", name=" + name + ", userStatus="
                + userStatus + ", statusDate=" + statusDate + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((articles == null) ? 0 : articles.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((statusDate == null) ? 0 : statusDate.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((userStatus == null) ? 0 : userStatus.hashCode());
        result = prime * result + (int) (version ^ (version >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserDetails other = (UserDetails) obj;
        if (articles == null) {
            if (other.articles != null)
                return false;
        } else if (!articles.equals(other.articles))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (statusDate == null) {
            if (other.statusDate != null)
                return false;
        } else if (!statusDate.equals(other.statusDate))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        if (userStatus != other.userStatus)
            return false;
        if (version != other.version)
            return false;
        return true;
    }

  

    
}
