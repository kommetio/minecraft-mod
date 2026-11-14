# Mod development, build, and installation

This project targets Java 25, Minecraft 26.3, and NeoForge 26.3.0.103. NeoForge's supported development template uses Gradle, so this project uses the Gradle wrapper rather than Maven.

## Create and run

1. Use the NeoForge ModDevGradle template with Minecraft 26.3 and JDK 25. The project keeps its NeoForge and Gradle versions in `gradle.properties`, `build.gradle`, and `gradle/wrapper/gradle-wrapper.properties`.
2. Put Java code under `src/main/java` and textures, item models, and translations under `src/main/resources/assets/cat_widmo991`. Put the mod metadata template in `src/main/templates/META-INF/neoforge.mods.toml`; Gradle expands its version and mod ID values into the build output.
3. Implement the mod entry point and features using the NeoForge API. Keep the `mod_id` in `gradle.properties`, the `@Mod` annotation, and the metadata consistent.
4. From the project root, launch the configured development client:

   ```powershell
   .\gradlew.bat runClient
   ```

   In a Creative world, use the **White Silhouette Spawn Egg** from the **Spawn Eggs** tab. The entity wanders peacefully and has only a white square head and torso.

## Build

Build the distributable JAR with the Gradle wrapper:

```powershell
.\gradlew.bat build
```

The distributable JAR is written to `build\libs`. Use the built mod JAR, not a development or sources JAR.

### GitHub Actions

Every push triggers the [build workflow](../.github/workflows/build.yml), which uses Java 25 to build the mod. It can also be started manually from the repository's Actions tab.

To download a build, open **Actions > Build mod**, select a successful run, and download the `mod-<commit SHA>` artifact. Extract the ZIP to obtain the distributable JAR. Artifacts are retained for 30 days; this does not publish a GitHub release or upload to CurseForge.

## Install and deploy

1. Create or select a CurseForge profile using Minecraft 26.3 and NeoForge 26.3. Install the matching Minecraft version and loader on any target server as well.
2. Copy the mod JAR and any required runtime dependencies into that instance's `mods` directory. For a standard Windows launcher instance, this is typically `%APPDATA%\.minecraft\mods`; custom launchers use their instance-specific `mods` directory.
3. Start the profile and confirm the mod loads. For multiplayer, deploy compatible versions of the mod and its dependencies to both the server and clients as required by NeoForge.

Distribute the built JAR together with the supported Minecraft version, NeoForge version, and dependency requirements. Do not distribute build caches or development run files.
