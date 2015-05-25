/**
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 */
package org.quartz.triggers;

import java.util.Date;

import org.quartz.core.Calendar;
import org.quartz.jobs.JobDataMap;

/**
 * Defines the setters for Trigger
 */
public interface MutableTrigger extends Trigger {

  /**
   * <p>
   * Set the name of this <code>Trigger</code>.
   * </p>
   *
   * @exception IllegalArgumentException if name is null or empty.
   */
  public void setName(String key);

  /**
   * <p>
   * Set the name of the associated <code>{@link org.quartz.jobs.JobDetail}</code>.
   * </p>
   *
   * @exception IllegalArgumentException if jobName is null or empty.
   */
  public void setJobName(String key);

  /**
   * <p>
   * Set a description for the <code>Trigger</code> instance - may be useful for remembering/displaying the purpose of the trigger, though the
   * description has no meaning to Quartz.
   * </p>
   */
  public void setDescription(String description);

  /**
   * <p>
   * Associate the <code>{@link Calendar}</code> with the given name with this Trigger.
   * </p>
   *
   * @param calendarName use <code>null</code> to dis-associate a Calendar.
   */
  public void setCalendarName(String calendarName);

  /**
   * <p>
   * Set the <code>JobDataMap</code> to be associated with the <code>Trigger</code>.
   * </p>
   */
  public void setJobDataMap(JobDataMap jobDataMap);

  /**
   * The priority of a <code>Trigger</code> acts as a tie breaker such that if two <code>Trigger</code>s have the same scheduled fire time, then
   * Quartz will do its best to give the one with the higher priority first access to a worker thread.
   * <p>
   * If not explicitly set, the default value is <code>5</code>.
   * </p>
   *
   * @see #DEFAULT_PRIORITY
   */
  public void setPriority(int priority);

  /**
   * <p>
   * The time at which the trigger's scheduling should start. May or may not be the first actual fire time of the trigger, depending upon the type of
   * trigger and the settings of the other properties of the trigger. However the first actual first time will not be before this date.
   * </p>
   * <p>
   * Setting a value in the past may cause a new trigger to compute a first fire time that is in the past, which may cause an immediate misfire of the
   * trigger.
   * </p>
   */
  public void setStartTime(Date startTime);

  /**
   * <p>
   * Set the time at which the <code>Trigger</code> should quit repeating - regardless of any remaining repeats (based on the trigger's particular
   * repeat settings).
   * </p>
   *
   * @see TriggerUtils#computeEndTimeToAllowParticularNumberOfFirings(Trigger, Calendar, int)
   */
  public void setEndTime(Date endTime);

  /**
   * <p>
   * Set the instruction the <code>Scheduler</code> should be given for handling misfire situations for this <code>Trigger</code>- the concrete
   * <code>Trigger</code> type that you are using will have defined a set of additional <code>MISFIRE_INSTRUCTION_XXX</code> constants that may be
   * passed to this method.
   * </p>
   * <p>
   * If not explicitly set, the default value is <code>MISFIRE_INSTRUCTION_SMART_POLICY</code>.
   * </p>
   *
   * @see #MISFIRE_INSTRUCTION_SMART_POLICY
   * @see #updateAfterMisfire(Calendar)
   * @see SimpleTrigger
   * @see CronTrigger
   */
  public void setMisfireInstruction(int misfireInstruction);

  public Object clone();

}