package com.example.phportfolio.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
public class ImagesCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalDate date;

    @OneToOne
    private Image preImage;
    @OneToOne
    private Image titleImage;

    @OneToMany
    private Set<Image> imageslist;

    public ImagesCollection() {
    }

    public ImagesCollection(String title, String description, LocalDate date, Image preImage, Image titleImage, Set<Image> imageslist) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.preImage = preImage;
        this.titleImage = titleImage;
        this.imageslist = imageslist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagesCollection that = (ImagesCollection) o;
        return id.equals(that.id) &&
                title.equals(that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, date);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Image getPreImage() {
        return preImage;
    }

    public void setPreImage(Image preImage) {
        this.preImage = preImage;
    }

    public Image getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(Image titleImage) {
        this.titleImage = titleImage;
    }

    public Set<Image> getImageslist() {
        return imageslist;
    }

    public void setImageslist(Set<Image> imageslist) {
        this.imageslist = imageslist;
    }

    @Override
    public String toString() {
        return "ImagesCollection{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", preImage=" + preImage +
                ", titleImage=" + titleImage +
                ", imageslist=" + imageslist +
                '}';
    }
}
