java -jar src/test/drivers/selenium-server-standalone-3.11.0.jar -role hub -host "127.0.0.1" &
appium --nodeconfig src/app/nodes-config/android-node1.json -p 1234 -cp 1234  &
appium --nodeconfig src/app/nodes-config/android-node2.json -p 3456 -cp 3456 &
appium --nodeconfig src/app/nodes-config/ios-node.json -p 4730 -cp 4730 &
~/Library/Android/sdk/emulator/emulator -avd "Pixel_3_XL_API_29"
~/Library/Android/sdk/emulator/emulator -avd "Nexus_5X_API_29"
open -a Simulator --args -CurrentDeviceUDID D4A14667-1951-4D09-88B0-B61E490C0311



