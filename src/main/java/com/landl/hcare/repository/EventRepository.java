package com.landl.hcare.repository;

import com.landl.hcare.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
    List<Event> findBySurgeryAreaId(Long surgeryAreaId);
    List<Event> findBySurgeryAreaIdAndStartBetween(Long surgeryAreaId, Date start, Date end);
    /*
    @Query(value = "select " +
            "to_char(available_schedule,(select pro.property_value from property pro where pro.property_code = 'timeformat')) as available_schedule_formatted," +
            "to_char(available_schedule,'YYYY-MM-DD\"T\"HH24:MI:SS\"Z\"') as available_schedule_iso" +
            " from ( select generate_series(ev.start_schedule::::timestamp, (ev.end_schedule - interval '1 'minute')::::timestamp, (:durationMinutes || ' minute')::::interval)::::timestamp  as available_schedule\n" +
            "from event ev where ev.surgery_area_id = :surgeryAreaId and ev.start_schedule::::date = (:isoDate)::::date) as schedule_source", nativeQuery = true)
    List<Object[]> getAvailableDatetimesInSurgeryArea(String isoDate, Long surgeryAreaId, Integer durationMinutes);
    */
    @Query(value = "select available_schedule::::timestamp, (available_schedule + (:durationMinutes || ' minute')::::interval)::::timestamp, surgery_area_id::::bigint  from (" +
            "select ev.surgery_area_id, generate_series(ev.start_schedule::::timestamp, (ev.end_schedule - interval '1 minute')::::timestamp, (:durationMinutes || ' minute')::::interval)::::timestamp  as available_schedule\n" +
            "from event ev where ev.surgery_area_id = :surgeryAreaId and ev.start_schedule::::date = (:isoDate)::::date) as available_schedules", nativeQuery = true)
    List<Object[]> getAvailableDatesInSurgeryArea(String isoDate, Long surgeryAreaId, Integer durationMinutes);

    @Query(value = "select available_schedule::::timestamp, (available_schedule + (:durationMinutes || ' minute')::::interval)::::timestamp, surgery_area_id::::bigint  from (" +
            "select ev.surgery_area_id, generate_series(ev.start_schedule::::timestamp, (ev.end_schedule - interval '1 minute')::::timestamp, (:durationMinutes || ' minute')::::interval)::::timestamp  as available_schedule\n" +
            "from event ev where ev.start_schedule::::date = (:isoDate)::::date) as available_schedules", nativeQuery = true)
    List<Object[]> getAvailableDatesBySurgeryType(String isoDate, Integer durationMinutes);

}
