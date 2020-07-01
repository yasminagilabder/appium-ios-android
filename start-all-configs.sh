java -jar src/test/drivers/selenium-server-standalone-3.11.0.jar -role hub -host "127.0.0.1" &
appium --nodeconfig src/app/nodes-config/android-node1.json -p 1234 -cp 1234  &
appium --nodeconfig src/app/nodes-config/android-node2.json -p 3456 -cp 3456 &
appium --nodeconfig src/app/nodes-config/android-node3.json -p 3476 -cp 3476 &
appium --nodeconfig src/app/nodes-config/ios-node1.json -p 4730 -cp 4730 &
appium --nodeconfig src/app/nodes-config/ios-node2.json -p 4790 -cp 4790 &
ios-sim showdevicetypes
ios-sim start --devicetypeid "iPhone-11-Pro-Max, 13.5" &
xcrun simctl addmedia booted ./src/test/resources/receipts/DE_RECEIPT1.jpg
ios-sim start --devicetypeid "iPhone-8, 13.5" &
xcrun simctl addmedia booted ./src/test/resources/receipts/DE_RECEIPT1.jpg &
emulator -list-avds
~/Library/Android/sdk/emulator/emulator -avd "Nexus_S_API_29" -port 5554 &
~/Library/Android/sdk/emulator/emulator -avd "Pixel_XL_API_28" -port 5556
