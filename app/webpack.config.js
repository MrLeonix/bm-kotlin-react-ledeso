const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const CopyPlugin = require("copy-webpack-plugin");

const buildDir = path.resolve(__dirname, "dist");
const rootDir = path.resolve(__dirname);

module.exports = {
  entry: {
    index: "./src/index.tsx",
  },
  mode: "development",
  devtool: "source-map",
  devServer:{
    historyApiFallback: true,
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: path.resolve(rootDir, "public", "index.html"),
      publicPath: "/",
    }),
    new CopyPlugin({
      patterns: [
        {
          from: path.resolve(rootDir, "public", "favicon.ico"),
          to: path.resolve(buildDir, "public", "favicon.ico"),
        },

      ],
    }),
  ],
  module: {
    rules: [
      {
        test: /\.css$/i,
        use: ["style-loader", "css-loader"],
      },
      {
        test: /\.(ts|tsx)$/i,
        use: "ts-loader"
      },
      {
        test: /\.(png|jpe?g|gif|svg|eot|ttf|woff|woff2)$/i,
        // More information here https://webpack.js.org/guides/asset-modules/
        type: "asset",
      },
    ],
  },
  resolve: {
    extensions: [".ts", ".tsx", ".js"],
  },
  output: {
    filename: "bundle.[fullhash].js",
    path: buildDir,
    clean: true,
  },
};
