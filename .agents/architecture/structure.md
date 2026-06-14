# Architecture & Technical Standards — `plugin-bukkit`

## Repository Scope

This repository is the **`bukkit`** module of the MCEconomy project, split out into its own
repository. It publishes the Maven artifact `io.github.mcclauneck:bukkit`.

## Rules

- This module is dedicated to handling core event structures and API interactions specific to
  the Bukkit platform (custom events and listeners reused by every platform).
- Compile against the SpigotMC API only (`org.spigotmc:spigot-api`, `compileOnly`). Do NOT pull
  in Paper- or Folia-specific APIs here.
- Do NOT change the Maven artifactId. `rootProject.name` MUST remain `bukkit`, even though the
  repository is named `plugin-bukkit`, so published coordinates stay `io.github.mcclauneck:bukkit`.

## Dependencies

Resolved from GitHub Packages:

- `io.github.mcclauneck:api` (`api` configuration — exposed transitively) — `MCClauneck/plugin-api`.
- `io.github.mcclauneck:common` (`implementation`) — `MCClauneck/plugin-common`.

## Position in the multi-repository project

This module is consumed by the platform repositories (`plugin-papermc`, `plugin-spigotmc`,
`plugin-foliamc`) as a published Maven artifact.
