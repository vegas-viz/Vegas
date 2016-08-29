# Contributing

Contributions encouraged! 

* Submit contributions as pull requests. The PR should include a brief
note describing the changes.

* Any new functionality should include a unit test. Unit tests should 
be written in FlatSpec style, with each clause being small and testing a 
single thing.

#  Test setup and run

The tests make use of ChromeDriver. First, you obviously need Chrome installed.
Next you need to install ChromeDriver, which you can do on mac with the 
following:

    ```bash
    brew install chromedriver
    ```

This also places chromeddriver on the shell path, which should be all you need.

* Running the unit tests

    ```bash
    sbt test
    ```

* Looking at example plots. The unit tests can only go so far (although 
we try to make them complete), so this command renders all the example
plots out an HTML page and opens it in your browser.

    ```bash
    sbt look
    ```
 
# Dev and debugging tips

* Generate the vega code. Most of the vega-lite json encoding/decoding is 
auto-magically generated from macros (fromSchemaResource...). If you're 
looking to expose a new option in the DSL, or wanting to debug something 
it can be helpful to manually inspect the produced code. The following 
sbt command writes the generated code out to ```[project-root]/core/target/scala-2.11/src_managed/it/Vega.scala```.

    ```bash
    sbt writeVegaSchema
    ```

* Updating vega-lite dependency version. If you want to pull in a new version 
of vega-lite. First, in build.sbt, update the vegaLiteVersion setting in 
commonSettings. Second, run the following sbt command to download the new 
vega-lite release.
 
    ```bash
    sbt updateVegaDeps
    ```

# Releasing

Releases are managed by the core team, but documenting the process here 
because we sometimes forget too :)

The workflow for releases are managed through sbt. You need to have ```~/.sbt/0.13/sonatype.sbt``` 
configured with the Sonatype credientials (which core contributors should have)

1. Run the following and follow prompts for version bumps, etc. This script
runs the tests, bumps the version, tags the release, commits those changes,
releases the package to Sonatype, and completes the Sontatype release
process.

    ```bash
    sbt release
    ```

2. Go to the Vegas github [repo](https://github.com/aishfenton/Vegas) and
add release notes under "releases" 

