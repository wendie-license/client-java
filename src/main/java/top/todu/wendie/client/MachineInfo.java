package top.todu.wendie.client;

import oshi.SystemInfo;

/**
 * 描述 <br>
 *
 * @author sdvdxl <杜龙少> <br>
 * @date 2020/4/13 13:24 <br>
 */
public class MachineInfo {
  /** CPU 序列号 */
  private String cpuSerial;
  /** 主板序列号 */
  private String baseboardSerial;
  /** 主硬盘 */
  //  private String mainHardDiskSerial;

  private MachineInfo() {}

  /** 系统uuid，跟bios相关 只有linux才有 */
  //  private String productUuid;

  public static void main(String[] args) {
    MachineInfo machineInfo =
        MachineInfo.builder().enableCpuSerial().enableBaseboardSerial().build();
    System.out.println(machineInfo);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "MachineInfo{"
        + "cpuSerial='"
        + cpuSerial
        + '\''
        + ", baseboardSerial='"
        + baseboardSerial
        + '\''
        + '}';
  }

  public static class Builder {
    private static final SystemInfo SYSTEM_INFO = new SystemInfo();
    /** CPU 序列号 */
    private boolean cpuSerial;

    /** 主板序列号 */
    private boolean baseboardSerial;

    /** 主硬盘 */
    //    private boolean mainHardDiskSerial;

    /** 系统uuid，跟bios相关 只有linux才有 */
    //    private boolean productUuid;

    public Builder() {}

    public MachineInfo build() {
      MachineInfo machineInfo = new MachineInfo();
      if (this.baseboardSerial) {
        machineInfo.baseboardSerial =
            SYSTEM_INFO.getHardware().getComputerSystem().getBaseboard().getSerialNumber();
      }

      if (this.cpuSerial) {
        machineInfo.cpuSerial = SYSTEM_INFO.getHardware().getProcessor().getProcessorID();
      }

      return machineInfo;
    }

    public Builder enableBaseboardSerial() {
      this.baseboardSerial = true;
      return this;
    }

    public Builder enableCpuSerial() {
      this.cpuSerial = true;
      return this;
    }
  }
}
