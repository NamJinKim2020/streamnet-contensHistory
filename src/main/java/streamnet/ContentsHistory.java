package streamnet;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="ContentsHistory_table")
public class ContentsHistory {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private Long watchCount;
    private String status;
    private Long contentsId;

    @PrePersist
    public void onPrePersist(){
        System.out.println("onPre Forfeiture");

        try {
            System.out.println("Thread Sleep");
            Thread.currentThread().sleep((long) (450 + Math.random() * 230));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @PostPersist
    public void onPostPersist(){
        Inserted inserted = new Inserted();
        BeanUtils.copyProperties(this, inserted);
        inserted.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Long getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(Long watchCount) {
        this.watchCount = watchCount;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Long getContentsId() {
        return contentsId;
    }

    public void setContentsId(Long contentsId) {
        this.contentsId = contentsId;
    }




}
