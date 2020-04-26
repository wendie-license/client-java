package top.todu.wendie.client;

import io.jsonwebtoken.lang.Assert;
import org.junit.Test;

/**
 * 机器码测试 <br>
 *
 * @author sdvdxl <杜龙少> <br>
 * @date 2020/4/26 12:58 <br>
 */
public class MachineInfoTest {
  @Test
  public void testGetMachineCode() {
    MachineInfo machineInfo =
        MachineInfo.builder().enableCpuSerial().enableBaseboardSerial().build();
    System.out.println(machineInfo);
    Assert.notNull(machineInfo.getBaseboardSerial());
    Assert.notNull(machineInfo.getCpuSerial());

    Assert.notNull(machineInfo.getMachineCode());
  }
}
