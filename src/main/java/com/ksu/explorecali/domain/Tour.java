package com.ksu.explorecali.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

/**
 * The Tour contains all attributes of an Explore California Tour.
 * <p>
 * Created by Mary Ellen Bowman
 */
@Document
public class Tour {
    @Id
    private String id;

    @Indexed
    private String title;

    @Indexed
    private String tourPackageCode;

    private String tourPackageName;

    private Map<String, String> details;

    public Tour(String title, TourPackage tourPackage, Map<String, String> details) {
        this.title = title;
        this.tourPackageCode = tourPackage.getCode();
        this.tourPackageName = tourPackage.getName();
        this.details = details;
    }

    protected Tour() {
    }

    public String getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        if (id != null ? !id.equals(tour.id) : tour.id != null) return false;
        if (title != null ? !title.equals(tour.title) : tour.title != null) return false;
        if (tourPackageCode != null ? !tourPackageCode.equals(tour.tourPackageCode) : tour.tourPackageCode != null)
            return false;
        if (tourPackageName != null ? !tourPackageName.equals(tour.tourPackageName) : tour.tourPackageName != null)
            return false;
        return details != null ? details.equals(tour.details) : tour.details == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (tourPackageCode != null ? tourPackageCode.hashCode() : 0);
        result = 31 * result + (tourPackageName != null ? tourPackageName.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", tourPackageCode='" + tourPackageCode + '\'' +
                ", tourPackageName='" + tourPackageName + '\'' +
                ", details=" + details +
                '}';
    }
}
