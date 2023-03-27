Usage instructions for Tile Component
The Tile Component provides a component that can be used to create a tile with hover effect. Here are the steps to use the library in your Angular project:

## Installation
To use the Tile Component, you need to install it as a dependency in your Angular project. Run the following command in your project's root directory:

`npm install @lht/tile --save`

This will install the library and save it as a dependency in your project's `package.json` file.

## Importing the module
After installing the library, you need to import the TileModule in your Angular module.

```typescript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { TileModule } from '@lht/tile';

@NgModule({
  imports: [BrowserModule, TileModule],
  declarations: [AppComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
```
## Using the component
Once you have imported the module, you can use the angular-hover-tile component in your Angular templates.

```html
<lht-tile href="/home">
  <div content>
    <!-- Content for the default state of the tile goes here -->
  </div>
  <div hover-content>
    <!-- Content for the hover state of the tile goes here -->
  </div>
</lht-tile>
```
The tile component takes two content slots: content and hover-content. The content in the content slot is displayed when the tile is in its default state, and the content in the hover-content slot is displayed when the tile is in its hover state.

The `href` attribute is optional and can be used to specify the destination of the tile link. If the href attribute is not present, the tile will not be clickable.

## Styling the component
The angular-hover-tile component has default styles, but you can override them by adding your own styles to your Angular component or global stylesheet.

Here are the CSS classes that you can use to style the component:

`.default`: Styles for the default state of the tile

`.hover`: Styles for the hover state of the tile

For example, to change the background color of the tile in its default state, you can add the following styles to your component or global stylesheet:

```scss
angular-hover-tile .default {
  background-color: #f1f1f1;
}
```